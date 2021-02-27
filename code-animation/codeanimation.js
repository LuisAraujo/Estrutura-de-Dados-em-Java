createCanvas = function(parent, id, w, h){
		h = h!=undefined?h:300;
		w = w!=undefined?w:700;
		
		var element = '<div class="viwer-animation-code"><div class="title">';
		
		element += '<input id="titleproject'+id+'" type="text" value="Untitle"></input></div>'

		element += '<div class="container-menu">'

		element += '<div title="exportar como img" class="bt"><i class="far fa-image"></i></div>'
			
		element += '<div title="exportar codigo" class="bt"><i class="far fa-file-code"></i></div></div>'
			

		element += '<div class="container-code" id="container-code'+id+'">'
		element += '<div class="container-mini-menu">'
		element += '<div ref="'+id+'" class="mini-bt play-code"><i class="fas fa-play"></i></div>'
				
		element += '<div  ref="'+id+'" class="mini-bt stop-code"><i class="fas fa-stop"></i></div>'
				
		element += '<div  ref="'+id+'" class="mini-bt prior-code"><i class="fas fa-backward"></i></div>'
				
		element += '<div  ref="'+id+'" class="mini-bt next-code"><i class="fas fa-forward"></i>		</div>'
				
		element +='<div  ref="'+id+'" class="mini-bt"><i class="fas fa-sync"></i></div></div>'
			
		element +='<div id="code'+id+'"></div></div>'

		element +='<div class="container-canvas" id="container-canvas">'
		element +='<canvas class="canvas" id="canvas'+id+'" width="'+w+'px" height="'+h+'px"> </canvas></div>'

		//element +='<div class="container-scenes" id="container-scenes'+id+'"><div class="h-scene">Cenas</div></div>'

		element +='<input id="file-project" accept="xml" type="file" hidden></div>'

		$(parent).html(element);
}
	
	
canvasanimations = [];
elems = $(".teste");

for(let i =0; i < elems.length; i++){
	createCanvas( elems[i], i, $(elems[i]).attr("wcanvas"), $(elems[i]).attr("hcanvas"));
	main = new Main(i);
	main.loadProject(new Reader( $(elems[i]).attr("filename")));
	main.start();
	canvasanimations.push(main);
}

setMenuEdit();