function Square(id, l, x, y, color, bg, linew){
	this.id = id;
	this.x = x;
	this.y = y;
	this.l = l;
	this.color = color;
	this.bg = bg;
	this.linew = linew?linew:1;
};

Square.prototype.print = function(ctx){
	ctx.save();
	
	ctx.fillStyle= this.bg;
    ctx.fillRect(this.x, this.y, this.l  , this.l); 
	
	ctx.strokeStyle = this.color;
	ctx.lineWidth = this.linew;
	ctx.strokeRect(this.x, this.y, this.w  , this.l); 
	
	ctx.restore();
	 
}