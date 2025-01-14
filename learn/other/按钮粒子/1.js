

var btn = document.querySelector(".button1");
var ctx;
var colorInfoElem = document.querySelector("#colorInfo");

html2canvas(btn).then(canvas => {
  ctx = canvas.getContext("2d");
  
  createParticleCanvas();
  
  btn.addEventListener("click", e => {
    // Get our color data like before
    let localX = e.offsetX;
    let localY = e.offsetY;
    let rgbaColorArr = ctx.getImageData(localX, localY, 1, 1).data;

    // Get the button's positioning in terms of the window
    let bcr = btn.getBoundingClientRect();
    let globalX = bcr.left + localX;
    let globalY = bcr.top + localY;

    // Create a particle using the color we obtained at the window location
    // that we calculated
    createParticleAtPoint(globalX, globalY, rgbaColorArr);
  });
});


/* An "exploding" particle effect that uses circles */
var ExplodingParticle = function() {
  // Set how long we want our particle to animate for
  this.animationDuration = 1000; // in ms

  // Set the speed for our particle
  this.speed = {
    x: -5 + Math.random() * 10,
    y: -5 + Math.random() * 10
  };
  
  // Size our particle
  this.radius = 5 + Math.random() * 5;
  
  // Set a max time to live for our particle
  this.life = 30 + Math.random() * 10;
  this.remainingLife = this.life;
  
  // This function will be called by our animation logic later on
  this.draw = ctx => {
    let p = this;

    if(this.remainingLife > 0
    && this.radius > 0) {
      // Draw a circle at the current location
      ctx.beginPath();
      ctx.arc(p.startX, p.startY, p.radius, 0, Math.PI * 2);
      ctx.fillStyle = "rgba(" + this.rgbArray[0] + ',' + this.rgbArray[1] + ',' + this.rgbArray[2] + ", 1)";
      ctx.fill();
      
      // Update the particle's location and life
      p.remainingLife--;
      p.radius -= 0.25;
      p.startX += p.speed.x;
      p.startY += p.speed.y;
    }
  }
}

var particles = [];
function createParticleAtPoint(x, y, colorData) {
  let particle = new ExplodingParticle();
  particle.rgbArray = colorData;
  particle.startX = x;
  particle.startY = y;
  particle.startTime = Date.now();
  
  particles.push(particle);
}


var particleCanvas, particleCtx;
function createParticleCanvas() {
  // Create our canvas
  particleCanvas = document.createElement("canvas");
  particleCtx = particleCanvas.getContext("2d");
  
  // Size our canvas
  particleCanvas.width = window.innerWidth;
  particleCanvas.height = window.innerHeight;
  
  // Position out canvas
  particleCanvas.style.position = "absolute";
  particleCanvas.style.top = "0";
  particleCanvas.style.left = "0";
  
  // Make sure it's on top of other elements
  particleCanvas.style.zIndex = "1001";
  
  // Make sure other elements under it are clickable
  particleCanvas.style.pointerEvents = "none";
  
  // Add our canvas to the page
  document.body.appendChild(particleCanvas);
}



function update() {
  // Clear out the old particles
  if(typeof particleCtx !== "undefined") {
    particleCtx.clearRect(0, 0, window.innerWidth, window.innerHeight);
  }

  // Draw all of our particles in their new location
  for(let i = 0; i < particles.length; i++) {
    particles[i].draw(particleCtx);
    
    // Simple way to clean up if the last particle is done animating
    if(i === particles.length - 1) {
      let percent = (Date.now() - particles[i].startTime) / particles[i].animationDuration;
      
      if(percent > 1) {
        particles = [];
      }
    }
  }
  
  // Animate performantly
  window.requestAnimationFrame(update);
}
window.requestAnimationFrame(update);