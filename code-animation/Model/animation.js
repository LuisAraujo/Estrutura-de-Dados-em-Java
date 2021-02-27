function Animation(id, code, scenes){
	this.id = id;
	this.code = code;
	this.scenes = scenes;
	this.current_scene = -1;
};


Animation.prototype.size = function(){
	
	return  this.scenes.length;
	
}

Animation.prototype.getCurrentScene = function(){
	
	return  this.scenes[this.current_scene];
	
}

Animation.prototype.setCurrentScene = function(current_scene){
	
	this.current_scene = current_scene;
	
}


Animation.prototype.getIndexCurrentScene = function(){
	
	return  this.current_scene;
	
}



Animation.prototype.setScene = function(scenes){
	
	this.scenes = scenes;
	
}


Animation.prototype.addScene = function(scene){
	
	this.scenes.push(scene);
	
}


Animation.prototype.setCode = function(code){
	
	this.code = code;
	
}
