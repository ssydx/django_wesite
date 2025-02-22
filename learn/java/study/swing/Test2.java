package study.swing;

import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Locale;

import javax.swing.*;

class Style_test {
    public static final void run() {

    }
}


public class Test2 {
    public static void main(String[] args) {
        JFrame jf = new JFrame();

        // Component

        // 不具备视觉效果，仅作为标记
        jf.setName("ssydx");
        System.out.println("名字：" + jf.getName());

        // 位置尺寸
        Point p = new Point(100, 100);
        jf.setLocation(p);
        Dimension d = new Dimension(300, 300);
        jf.setSize(d);
        jf.setBounds(150, 150, 500, 300);
        System.out.println("X坐标：" + jf.getX());
        System.out.println("X坐标：" + jf.getY());
        System.out.println("XY坐标：" + jf.getLocation());
        System.out.println("高度：" + jf.getHeight());
        System.out.println("宽度：" + jf.getWidth());
        System.out.println("高宽度：" + jf.getSize());
        System.out.println("位置尺寸：" + jf.getBounds());

        // 颜色
        Container jfp = jf.getContentPane();// 直接设置顶级容器的颜色是无效的，要取其内部容器
        Color c = new Color(200, 100, 50, 128);
        jfp.setBackground(c);
        jfp.setForeground(Color.BLUE); // 顶级容器的前景色通常没有意义
        System.out.println("背景色：" + jf.getBackground());

        // 光标
        Cursor cur = new Cursor(4);
        jf.setCursor(cur);
        System.out.println("光标类型：" + jf.getCursor());
        jf.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 字体，容器的字体无意义
        Font f = new Font(Font.SANS_SERIF, Font.ITALIC, 16);
        jfp.setFont(f);
        jf.setFont(f);
        System.out.println("字体：" + jf.getFont());

        // 最大最小化，往往不起效果
        jf.setMaximumSize(new Dimension(1000,500));
        System.out.println("最大尺寸：" + jf.getMaximumSize());
        jf.setMinimumSize(new Dimension(100,50));
        System.out.println("最小尺寸：" + jf.getMinimumSize());

        // 本地化，不起效，只对颜色日期等组件或本地化资源包起效
        jf.setLocale(Locale.ENGLISH);
        System.out.println("本地化：" + jf.getLocale());

        // 组件是否可交互（可用）
        jf.setEnabled(true);
        // 组件是否可获得焦点
        jf.setFocusable(true);

        System.out.println("父组件：" + jf.getParent());
        System.out.println("工具包：" + jf.getToolkit());

        // setMixingCutoutShape
        // setFocusTraversalKeys
        // setFocusTraversalKeysEnabled
        // setDropTarget
        // setPreferredSize
        // setIgnoreRepaint
        // setComponentOrientation
        // setMixingCutoutShape

        // 不支持直接添加
        // jf.add(new PopupMenu("abc"));

        // 组件事件，位置改变，尺寸改变，显示，隐藏
        jf.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent  e) {
                System.out.println("窗口大小改变");
            }
            public void componentMoved(ComponentEvent  e) {
                System.out.println("窗口位置移动");
            }
            public void componentShown(ComponentEvent  e) {
                System.out.println("窗口显示");
            }
            public void componentHidden(ComponentEvent  e) {
                // 只有setVisible(true);会触发
                System.out.println("窗口隐藏");
            }
        });

        // 前提是组件可获得焦点，获得焦点，失去焦点
        jf.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                System.out.println("获得焦点");
            }
            public void focusLost(FocusEvent e) {
                System.out.println("失去焦点");
            }
        });

        // 前提是组件可获得焦点，按键按下，按键释放，输出字符
        jf.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                System.out.println("按键按下：" + e.getKeyChar());
            }
            public void keyReleased(KeyEvent e) {
                System.out.println("按键释放：" + e.getWhen() + e.getKeyChar());
            }
            public void keyTyped(KeyEvent e) {
                System.out.println("输出字符");
            }
        });

        // 鼠标事件，光标进入，光标离开，鼠标按下，鼠标释放，单击完成
        jf.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                System.out.println("光标进入：" + e.getWhen());
            }
            public void mouseExited(MouseEvent e) {
                System.out.println("光标离开");
            }
            public void mousePressed(MouseEvent e) {
                System.out.println("鼠标按下");
            }
            public void mouseReleased(MouseEvent e) {
                System.out.println("鼠标释放：" + e.getButton());
            }
            public void mouseClicked(MouseEvent e) {
                System.out.println("单击完成");
            }
        });

        // 鼠标移动事件，鼠标拖拽（按下不松进行移动），鼠标移动
        jf.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("鼠标拖拽");
            }
            public void mouseMoved(MouseEvent e) {
                System.out.println("鼠标移动：" + e.getPoint());
            }
        });

        // 鼠标滚轮事件
        jf.addMouseWheelListener(e -> System.out.println("滚轮滚动：" + e.getWhen()));

        // 层次结构更改事件
        jf.addHierarchyListener(e -> System.out.println("结构更改"));

        // 属性事件
        jf.addPropertyChangeListener(e -> System.out.println("任意属性更改：" + e.getPropertyName()));
        jf.addPropertyChangeListener("background", e -> System.out.println("背景色更改" + "从" + e.getOldValue() + "变为" + e.getNewValue()));
        jf.setBackground(Color.DARK_GRAY);

        // addHierarchyBoundsListener
        // addInputMethodListener
        // addPropertyChangeListener
        // ...

        System.out.println("所有属性监听器：" + Arrays.toString(jf.getPropertyChangeListeners()));
        System.out.println("组件监听器：" + Arrays.toString(jf.getComponentListeners()));

        // 指定点是否在容器内，0-尺寸（不含）返回true
        System.out.println("是否包含指定点：" + jf.contains(499,0));
        // 对齐方式
        System.out.println("水平对齐：" + jf.getAlignmentX());
        System.out.println("垂直对齐：" + jf.getAlignmentY());
        // 获得子组件列表
        jf.list();

        // Container

        // 布局
        jf.setLayout(new FlowLayout(FlowLayout.LEFT,10, 10));
        System.out.println("布局管理器：" + jf.getLayout());

        // 要获取add添加的组件应该通过getContentPane
        System.out.println("组件数量：" + jf.getComponentCount());
        System.out.println("组件列表：" + Arrays.toString(jf.getComponents()));

        // 容器事件
        jf.getContentPane().addContainerListener(new ContainerListener() {
            public void componentRemoved(ContainerEvent e) {
                System.out.println("移除了组件");
            }
            public void componentAdded(ContainerEvent e) {
                System.out.println("增加了组件");
            }
        });

        // 增删组件
        JButton jb1 = new JButton("1");
        JButton jb2 = new JButton("2");
        // 增加
        jf.add(jb1);
        jf.add(jb2, 0);
        jf.add(new JButton("3"));
        // 数量列表
        System.out.println("组件数量：" + jf.getContentPane().getComponentCount());
        System.out.println("组件列表：" + Arrays.toString(jf.getContentPane().getComponents()));
        // 递归列出
        jf.getContentPane().list();
        // 删除
        jf.remove(jb2);
        // 注意，通过索引移除时必须显式获取pane
        jf.getContentPane().remove(0);

        // 借助Timer测试事件
        JButton jb = new JButton("按钮");
        jf.add(jb);
        Timer t = new Timer(1000, e -> {
            jf.remove(jb);
            // 重新验证
            jf.revalidate();
            // 重绘
            jf.repaint();
        });
        t.setRepeats(false);
        t.start();

        // Window

        // 窗口类型
        jf.setType(Window.Type.POPUP);
        System.out.println("窗口类型：" + jf.getType());

        // 窗口置顶
        jf.setAlwaysOnTop(true);
        System.out.println("窗口是否置顶" + jf.isAlwaysOnTop());

        // 窗口焦点事件
        jf.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("窗口获得焦点");
            }
            public void windowLostFocus(WindowEvent e) {
                System.out.println("窗口失去焦点");
            }
        });

        // 窗口状态事件
        jf.addWindowStateListener(new WindowStateListener() {
            public void  windowStateChanged(WindowEvent e) {
                System.out.println("窗口状态改变：" + "从" + e.getOldState() + "变为" + e.getNewState());
            }
            
        });

        // 窗口事件
        jf.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                System.out.println("窗口打开");
            }
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口关闭(普通关闭)");
            }
            public void windowClosed(WindowEvent e) {
                // dispose关闭时才生效
                System.out.println("窗口关闭(通过dispose)");
            }
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口激活");
            }
            public void windowDeactivated(WindowEvent e) {
                System.out.println("窗口失活");
            }
            public void windowIconified(WindowEvent e) {
                System.out.println("最小化");
            }
            public void windowDeiconified(WindowEvent e) {
                System.out.println("恢复正常");
            }
        });
        JButton jb5 = new JButton("关闭窗口");
        jb5.addActionListener(e -> jf.dispose());
        jf.add(jb5);

        // Frame

        jf.setTitle("测试JFrame");
        System.out.println("标题：" + jf.getTitle());
        jf.setResizable(true);
        System.out.println("是否可调整大小：" + jf.isResizable());
        // 可能造成菜单栏的错位
        jf.setMaximizedBounds(new Rectangle(10,10,1000,500));
        // 新建菜单栏
        MenuBar mb = new MenuBar();
        // 添加项
        Menu m;
        m = new Menu("ABC");
        mb.add(m);
        // 虽然有该指示，但未提供实现
        m = new Menu("123",true);
        m.add(new MenuItem("1"));
        m.add(new MenuItem("2"));
        m.add(new MenuItem("3", new MenuShortcut(KeyEvent.getExtendedKeyCodeForChar('A'))));
        System.out.println("二级菜单项数量：" + m.getItemCount());
        mb.add(m);
        Menu m1 = new Menu("甲乙丙");
        mb.add(m1);
        System.out.println("一级菜单项数量：" + mb.getMenuCount());
        jf.setMenuBar(mb);
        jf.remove(mb);
        System.out.println(jf.getMenuBar());
        // 取消标题栏
        jf.setUndecorated(true);
        // setExtendedState
        
        // JFrame
        // 菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu jm1 = new JMenu("第一个");
        jmb.add(jm1);
        JMenu jm2 = new JMenu("第二个");
        jm2.add(new JMenuItem("1",new ImageIcon(Test2.class.getResource("src/呵护.jpeg"))));
        jm2.add(new JMenuItem("2",3));
        jmb.add(jm2);
        jf.setJMenuBar(jmb);
        // 关闭即结束进程
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true); // 属于Component
    }
}
