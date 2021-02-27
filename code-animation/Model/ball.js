function Ball(id, r, x, y, color, bg, linew){
	this.id = id;
	this.r = r;
	this.x = x;
	this.y = y;	
	this.color = color;
	this.bg = bg;
	this.linew = linew?linew:1;
};


Ball.prototype.print = function(ctx){
	ctx.save();
	ctx.beginPath();
	ctx.arc(this.x +  this.r/2, this.y + this.r/2, this.r, 0, 2 * Math.PI);
	ctx.closePath(); 
	ctx.fillStyle= this.bg;
	ctx.fill();
	ctx.strokeStyle = this.color;
	ctx.lineWidth = this.linew;
	ctx.stroke();	
	ctx.restore();
		
}

