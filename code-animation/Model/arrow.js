function Arrow(id, x1, y1, x2, y2, color, linew, angle){
	this.id = id;
	this.x1 = x1;
	this.x2 = x2;
	this.y1 = y1;
	this.y2 = y2;
	this.color = color;
	this.linew = linew;
	this.angle = angle;
};

Arrow.prototype.print = function(ctx){
		ctx.save();
		
		ctx.beginPath();
		
		
		
		ctx.lineWidth = this.linew;
		
		var angle = this.angle * Math.PI / 180;
		var midX = this.x1 - (this.x2 - this.x1) * 0.5;
		var midY = this.y1 - (this.y2 - this.y1) * 0.5;
		
		ctx.translate(midX, midY);
		ctx.rotate(angle);
		ctx.translate(-midX, -midY);
		
		ctx.drawImage(window.main.direction,  this.x2  , this.y2-5, 10, 10);
		
		ctx.moveTo(this.x1,this.y1);
		ctx.lineTo(this.x2, this.y2);
		ctx.stroke();
		
		ctx.restore();


}



Arrow.prototype.print2 = function(ctx){
		ctx.save();
		
		ctx.beginPath();
		
		ctx.moveTo(this.x1, this.y1);
		ctx.lineTo(this.x2, this.y2);
		
		ctx.lineWidth = this.linew;
		ctx.stroke();
		var angle = Math.atan2(this.y2 - this.y1, this.x2 - this.x1) * 180 / Math.PI;
		
		var halfWidth = (10 / 2);
		var halfHeight = (10 / 2);
		
		var centreX = this.x2 - halfWidth;
		var centreY = this.y2 - halfHeight;

		ctx.translate(canvas.width/2, canvas.height/2);
		ctx.rotate(angle);

		ctx.drawImage(window.main.direction,  this.x2  , this.y2 - 10, 10, 10);
		
		ctx.restore();


}