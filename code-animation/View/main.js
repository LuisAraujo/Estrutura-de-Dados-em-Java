Main = function(id){
	this.direction = document.getElementById("direction");
	this.currentLine = 0;
	this.scenes = [];	
	this.code = [];
	this.currente_id = 0;
	this.render = null;
	this.id = id;
}

Main.prototype.createScene = function(){
	var sc = new Scene(10, this.scenes.length);
	this.scenes.push(sc);
	return sc;
}


Main.prototype.getScene = function(index){
	 
	// return [];
	 
	 if ((index>-1) && (index < this.scenes.length) )
		return this.scenes[index];
	return null;
}


Main.prototype.setCode = function(code){
	this.code = new Code(code);
}


Main.prototype.start = function(){
	
	this.render = new Render(this.id);
	
	var animation = new Animation();
	animation.setScene( this.scenes );
	animation.setCode ( this.code );
	
	animation.setCurrentScene(0);	
	this.render.setAnimation(animation);
	
	this.render.start( this.code );

	
}

Main.prototype.loadProject = function(reader){
	
	 var name = reader.getNode('name').innerHTML;
	 $("#titleproject"+this.id).val(name);
	 var author = reader.getNode('author').innerHTML;
	 
	 for (var i = 0; i < reader.getSize('scenes'); i++) {
			
			subnode = reader.getNode('elems',i);
			code = reader.getNode('code').innerHTML.split("@");
			currrent_scene = this.createScene();
			
			this.setCode(code);
			
			
			for (var j = 0; j <subnode.childNodes.length; j++){

				
				elem_type = subnode.childNodes[j].nodeName;
				elem =  subnode.childNodes[j].innerHTML.split(";");
				id = this.currente_id++; 
				
				if(elem_type == "rect"){
					
					currrent_scene.add( 
						new Retangle(id, parseInt(elem[0]), parseInt(elem[1]), parseInt(elem[2]), parseInt(elem[3]), elem[4], elem[5], elem[6])
					)
				
				}else if(elem_type  == "text"){
				
					currrent_scene.add( 
						new Text(id, elem[0], parseInt(elem[1]), parseInt(elem[2]), parseInt(elem[3]), elem[4])
					);
					
				}
			}
			
			
	  }
  
  }