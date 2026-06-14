class Font
{
constructor(fontFamily,size,style=FontStyle.NORMAL)
{
this.fontFamily=fontFamily;
this.size=size;
this.style=style;
}
setFontFamily(fontFamily)
{
this.fontFamily=fontFamily;
}
getFontFamily()
{
return this.fontFamily;
}
setSize(size)
{
this.size=size;
}
getSize()
{
return this.size;
}
setStyle(style)
{
this.style=style;
}
getStyle()
{
return this.style;
}
toString()
{
return this.style+' '+this.size+'px '+this.fontFamily;
}
}