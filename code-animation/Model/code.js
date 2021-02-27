function Code(texts){
	this.texts = texts;
};

Code.prototype.get = function(index){
	return this.texts[index];	
}

Code.prototype.size = function(){
     return this.texts.length;	
}


