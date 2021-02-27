Render = function(id){
	this.animation;
	console.log("canvas"+id)
	this.ctx = document.getElementById("canvas"+id).getContext("2d");
	this.current_scene = -1;
	this.w = 400;
	this.h = 400;
	this.formater = new Formater();
	this.timeout;
	this.id = id;
}

Render.prototype.stop = function(){
	
	clearTimeout(this.timeout);
	
}

Render.prototype.next = function(){
	
	this.stop();
	
	if(( this.animation.getIndexCurrentScene() <  this.animation.size() -1 ) && (this.animation.getIndexCurrentScene() >= 0) ) {
		
		this.animation.setCurrentScene( this.animation.getIndexCurrentScene() + 1);
		
		this.cleanLine(_this.animation.getIndexCurrentScene()-1);
		this.heightlightLine(_this.animation.getIndexCurrentScene());
	
	}
		
	//this.updateScene(this, true);
}

Render.prototype.prior = function(){
	
	this.stop();
	if(this.animation.getIndexCurrentScene() > 0) {
		
		this.animation.setCurrentScene( this.animation.getIndexCurrentScene() - 1);
		
		this.cleanLine(_this.animation.getIndexCurrentScene()+1);
		this.heightlightLine(_this.animation.getIndexCurrentScene());
		
	}
	//this.updateScene(this, true);
}

Render.prototype.reload = function(){
	
	this.stop();	
	this.animation.setCurrentScene(0);
	this.cleanAllLines();
	this.play();
	
}


Render.prototype.play = function(){
	this.loop(this);
	//teste
	this.heightlightLine(this.animation.getIndexCurrentScene()  );
	//this.cleanLine(2);
	
	_this = this;
	this.timeout = setTimeout( function(){ _this.updateScene(_this) }, _this.animation.getCurrentScene().getTime() * 100 );
}


Render.prototype.start = function(){
	
	this.showLines(this.animation.code);
	this.setLines();
	//only editor
	//this.showScenes();
}

Render.prototype.updateScene  = function(_this, only){
	

	if( _this.animation.getIndexCurrentScene() <  _this.animation.size() -1 ) {
		
		_this.animation.setCurrentScene( _this.animation.getIndexCurrentScene() + 1);
		
		this.cleanLine(_this.animation.getIndexCurrentScene()-1);
		
		this.heightlightLine(_this.animation.getCurrentScene().getLineCode());
		
		if(only != true);
			_this.timeout =  setTimeout( function(){ _this.updateScene(_this) }, _this.animation.getCurrentScene().getTime() * 100 );
		
	}
	
}	


Render.prototype.add  = function(animation){
	this.animation = animation;
}

	
Render.prototype.showScene  = function(index){
	console.log(index);
	this.animation.setCurrentScene(index);
		
	this.cleanAllLines();
	this.heightlightLine(this.animation.getIndexCurrentScene());
		
	this.printall();
}	


Render.prototype.setAnimation = function(animation){
	this.animation = animation;
}	


Render.prototype.setCurrentScene  = function(number){
	this.current_scene = number;
}	

Render.prototype.printall = function(){
	
	var scene = this.animation.getCurrentScene();
	
	this.ctx.clearRect(0,0,this.w,this.h);
	
	if(scene != undefined){
	
		for(i=0; i < scene.size(); i++){
			scene.get(i).print(this.ctx);
		};
	}
}	

Render.prototype.loop = function(_this){	
	
	this.printall();
	window.requestAnimationFrame( function(){ _this.loop(_this)} );
}

Render.prototype.showScenes = function(){
	
	
  $("#container-scenes"+this.id).html( "<div class='h-scene'>Cenas</div>");
  
  for(var i = 0; i < this.animation.size(); i++)
	$("#container-scenes"+this.id).append( "<div tag='"+i+"' ref='"+this.id+"'  class='scene'>"+i+"</div>");
	
	
	$("#container-scenes"+this.id).append( "<div class='scene active' ref='"+this.id+"' >+</div>");
	
	$(".scene").click(function(){
		 canvasanimations[ $(this).attr("ref")].render.showScene( $(this).attr("tag" ) );
	});
}

Render.prototype.showLines = function(code){
	
	var divcode = document.getElementById("code"+this.id);
	
	for(var i = 0; i < code.size(); i++){
		
		var span = "<span class='n-line'> " + i + ". </span>  ";
		
		var div = document.createElement("div");
		div.classList.add("line"+ this.id);
		div.classList.add("line");
		var text = this.formater.getFormated ( code.get(i) ) 
		 
		div.innerHTML = span + text;
		
		divcode.appendChild(div);
		
		
	}
}

Render.prototype.setLines = function(){
	
	var lines = document.getElementsByClassName("line" + this.id);
	for(var i = 0; i < lines.length; i++){
		if(i%2 != 0)
			lines[i].classList.add("i");
		
	}
}


Render.prototype.heightlightLine = function(line){
	
	var lines = document.getElementsByClassName("line" + this.id);
	lines[line].classList.add("h");

}

Render.prototype.cleanLine = function(line){
	
	var lines = document.getElementsByClassName("line" + this.id);
	lines[line].classList.remove("h");

}


Render.prototype.cleanAllLines = function(line){
	
	var lines = document.getElementsByClassName("line" + this.id);
	for(var i = 0; i < lines.length; i++)
		lines[i].classList.remove("h");

}