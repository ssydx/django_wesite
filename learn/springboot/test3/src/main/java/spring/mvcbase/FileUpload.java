package spring.mvcbase;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUpload {
    private static final String UPLOAD_DIRECTORY ="/images";
    
    @RequestMapping("uploadform")
    public ModelAndView uploadForm(){
        return new ModelAndView("uploadpage"); 
    }
    
    @RequestMapping(value="savefile",method=RequestMethod.POST)
    public ModelAndView saveimage(@RequestParam CommonsMultipartFile file,
           HttpSession session) throws Exception {
    ServletContext context = session.getServletContext();
    String path = context.getRealPath(UPLOAD_DIRECTORY);
    String filename = new String(file.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
    System.out.println(filename);
    try {
        // 检查并创建目录
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        byte[] bytes = file.getBytes();
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path, filename)))) {
            stream.write(bytes);
        }
        return new ModelAndView("uploadpage", "filesuccess", "File successfully saved!");
    } catch (IOException e) {
        e.printStackTrace();
        return new ModelAndView("uploadpage", "fileerror", "Failed to save the file.");
    }
    }
}
