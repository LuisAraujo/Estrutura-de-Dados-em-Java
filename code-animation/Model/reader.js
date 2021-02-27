/**
* Essa classe é responsávl pela leitura de arquivos xml
* @class
*/
function Reader(path) {

    this.xml = null;

   if(path!=undefined){
        this.getFile(path);
    }
	
    if(this.xml.getElementsByTagName("parsererror").length > 0 )
        throw new Error("O seu arquivo XML possui algum erro!");


}

/**
 * obtem um nó do XML através da tag e do index, em caso de várias tags com o mesmo nome
 * @return {XML DOM} node - um nó do arquivo
 */
Reader.prototype.getNode = function(tag, index){
    if(index == undefined)
        index = 0;

   // return this.xml.getElementsByTagName(tag)[0].childNodes[index];
    return this.xml.getElementsByTagName(tag)[index];
}

/**
 * obtem o valor de um nó do XML  
 * @return {} value - valor no nó
 */
Reader.prototype.getValue = function(node){
 
    return node.innerHTML;
}


/**
 * obtem um filho nó do XML através do index
 * @return {XML DOM} node - um nó do arquivo
 */
Reader.prototype.getChild = function(node, index){
    if(index == undefined)
        index = 0;

    return node.childNodes[index];
}


/**
 * Obtem a quantidade de filhos de um nó do XML através da tag e o index
 * @return {int} size - tamanho do nó
 */
Reader.prototype.getSize = function(tag, index){
    if(index == undefined)
        index = 0;

    return this.xml.getElementsByTagName(tag)[index].children.length;
}




/**
 * obtem a quantidade de tags com esta tag no documento
 * @return {int} size - quantidade de tags
 */
 
Reader.prototype.getCount = function(tag){
    return this.xml.getElementsByTagName(tag).length;
}
	

Reader.prototype.getFile = function (path) {
	_this = this;
	
	var rawFile = new XMLHttpRequest();
		rawFile.open("GET",  path , false);
		rawFile.onreadystatechange = function ()
		{
			if(rawFile.readyState === 4)
			{
				if(rawFile.status === 200 || rawFile.status == 0)
				{
					var parser = new DOMParser();
					var xmlDoc = parser.parseFromString(rawFile.responseText,"text/xml");
					_this.xml = xmlDoc;

				}else{
					console.log("erro")
				}
			}
		}

		rawFile.send(null);
		
			
}
