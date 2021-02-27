function Text(id, text, size, x, y, color, font, line){
	this.id = id;
	this.x = x;
	this.y = y;
	this.text = text;
	this.color = color;
	this.line = line;
	this.size = size?size:30;
	this.font = font?font:"Arial";
};


Text.prototype.setText = function(text){
	this.text = text;
}


Text.prototype.print = function(ctx){
	ctx.save();
	
	ctx.font = this.size + "px " + this.font;
	ctx.fillStyle = this.color;
    ctx.fillText(this.text, this.x, this.y); 
	
	if(this.line != undefined){
		ctx.strokeStyle = this.line;
		//ctx.lineWidth = this.linew;
		ctx.strokeText(this.x, this.y); 
	}
	ctx.restore();
	 
}