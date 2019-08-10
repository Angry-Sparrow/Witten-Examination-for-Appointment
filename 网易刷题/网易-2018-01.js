/*
 * @Author: lee
 * @Date:2019/8/1 21:02
 * @Last Modified by:lee
 * @Last Modified time:2019/8/1 21:02
 */
    //  只有一处两个不同颜色相邻的情况

    var readline = require('readline');
    var re = readline.createInterface({
        input : process.stdin,
        output : process.stdout
    });
    re.on('line',function(input){
        var inputArr = removeRepeatStr(input);
        const len = inputArr.length;
        if(len > 2){
            console.log(0);
        }else if(len === 2){
            console.log(2);
        }else{
            console.log(1);
        }
    });
function removeRepeatStr(str) {
    var newStr = '';
    var len = str.length;
    for (var i = 0; i < len; i++) {
        if (newStr.indexOf(str[i]) === -1) {
            newStr = newStr + str[i];
        }
    }
    return newStr;
}





