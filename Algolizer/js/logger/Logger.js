const LoggerState=Object.freeze({
ON:"on",
OFF:"off",
});
class Logger
{
static state=LoggerState.OFF;
static setState(state)
{
this.state=state;
}
static getState()
{
return this.state;
}
static print(...args)
{
if(this.state===LoggerState.ON) console.log(...args);
else if(this.state===LoggerState.OFF);
}
}


