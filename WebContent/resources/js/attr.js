/**
 * jQuery 속성 예제
 */
var attr = {
	attrDemo : function(imgPath) {
		$('<img/>', {
			src : imgPath,
			width : '100%',
			height : '100%'
		}).appendTo($('#sampleBox').empty());
	},
	htmlDemo : function() {
		$('<div id="htmlBox"></div>').appendTo($('sampleBox').empty());
		$('#htmlBox').html('<span style="background : yellow;width:100px;height:100px;">노란박스</span>');
	},
	textDemo : function() {
		$('<div id="textBox"></div>').appendTo($('sampleBox').empty());
		$('#textBox').text('노란박스');
	}
}