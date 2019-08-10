/*
 * @Author: lee
 * @Date:2019/8/2 11:08
 * @Last Modified by:lee
 * @Last Modified time:2019/8/2 11:08
 */

var readline = require('readline');
var re = readline.createInterface({
    input : process.stdin,
    output : process.stdout
});
re.on('line',function(input){
    var arr = input.split(' ');
    var x = parseInt(arr[0]),
        f = parseInt(arr[1]),
        d = parseInt(arr[2]),
        p = parseInt(arr[3]);
    console.log(arr);
    if(f >= (d/x)){
        console.log(f);
    }else{
        var r = d - x*f;
        var y = Math.floor(r/(p + x));
        var total = f + y;
        console.log(total);
    }
});