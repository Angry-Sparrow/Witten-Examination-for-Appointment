/*
 * @Author: lee
 * @Date:2019/8/2 9:40
 * @Last Modified by:lee
 * @Last Modified time:2019/8/2 9:40
 */

var readline = require('readline');
var re = readline.createInterface({
    input : process.stdin,
    output : process.stdout
});
re.on('line',function(input){
    console.log(input);
    var inp = input;
    console.log(inp.length);
    var patt = /(10)+/g;
    var arr = input.match(patt);
    console.log(arr);
    if(arr != null){
        var maxLen = 0;
        var maxLenStr = '';
        var len = arr.length;
        for(var i = 0; i < len; i++){
            if(arr[i].length > maxLen){
                maxLen = arr[i].length;
                maxLenStr = arr[i];
            }
        }
        num = maxLen;
        var maxLenIndex = inp.indexOf(maxLenStr);
        if(inp[maxLenIndex-1] === '0'){
            num++;
        }
        if(inp[maxLenIndex+maxLen] === '1'){
            num++;
        }
        console.log(num);
    }else if((/(01)/g).test(input)){
        console.log(2);
    }else{
        console.log(1);
    }
});