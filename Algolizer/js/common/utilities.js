function delay(milliseconds)
{
return new Promise((resolve,reject)=>setTimeout(resolve,milliseconds));
}

const AlgorithmState=Object.freeze({
IDLE:"idle",
RUNNING:"running",
TERMINATED:"terminated",
FINISHED:"finished",
});

const Color=Object.freeze({
WHITE:"#ffffff",
BLACK:"#000000",
BLUE:"#0000ff",
RED:"#ff0000",
BROWN:"#a52a2a",
GREEN:"#008000",
DARK_GREEN:"#006400",
ORANGE:"#ffa500",
YELLOW:"#ffff00",
PURPLE:"#800080",
INDIGO:"#4b0082",
PINK:"#ffc0cb",
});

const FontStyle=Object.freeze({
NORMAL:"normal",
BOLD:"bold",
ITALIC:"italic"
});

const ArrayType=Object.freeze({
HORIZONTAL:"horizontal",
VERTICAL:"vertical",
});