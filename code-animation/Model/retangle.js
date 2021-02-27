function Retangle(id, h, w, x, y, color, bg, linew){
	this.id = id;
	this.x = x;
	this.y = y;
	this.h = h;
	this.w = w;
	this.color = color;
	this.bg = bg;
	this.linew = linew?linew:1;
};

Retangle.prototype.print = function(ctx){
	ctx.save();
	ctx.globalAlpha = 1;
	ctx.fillStyle= this.bg;
    ctx.fillRect(this.x, this.y, this.w  , this.h); 
	
	ctx.strokeStyle = this.color;
	ctx.lineWidth = this.linew;
	ctx.strokeRect(this.x, this.y, this.w, this.h); 
	
	ctx.restore();
	 
}