
// see http://api.jquery.com/
function ParseXML (textarea) 
{
	var xmlDoc = $.parseXML( textarea ),
	$xml = $( xmlDoc ),
	$title = $xml.find( "title" );
	$(".rss-reader").append( $title );
}
