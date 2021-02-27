function Scene(time, linecode){
	this.stack = [];
	this.linecode = linecode?linecode:1;
	this.time = time?time:10;
};


Scene.prototype.add = function(elem){
	this.stack.push(elem);		
}


Scene.prototype.get = function(index){
	return this.stack[index];	
}

Scene.prototype.set = function(elem, index){
	this.stack[index] = elem;	
}

Scene.prototype.size = function(){
     return this.stack.length;	
}

Scene.prototype.setTime = function(time){
	this.time = time;
}

Scene.prototype.getTime = function(){
	return this.time;
}

Scene.prototype.getAll = function(){
	return this.stack;
}


Scene.prototype.setAll = function(stack){
	for(var i = 0; i < stack.length; i++)
		this.stack.push(stack[i]);
}

Scene.prototype.setLineCode = function(linecode){
	this.linecode = linecode;
}

Scene.prototype.getLineCode = function(){	
	return this.linecode;
}



