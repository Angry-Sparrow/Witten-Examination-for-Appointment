/*
 * @Author: lee
 * @Date:2019/8/31 17:14
 * @Last Modified by:lee
 * @Last Modified time:2019/8/31 17:14
 */

// 数组去重，并从大到小排序
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
// var inputArr = [];
rl.on('line', function (input) {
    // console.log(input);
    var inputArr = input.split(",");
    // console.log(inputArr);
    // console.log(inputArr);
    var set = new Set(inputArr);
    var arr = Array.from(set);
    arr.sort();
    arr.reverse();
    var str = "";
    for(var i=0;i<arr.length;i++) {
        if (i === arr.length - 1) {
            str += str + arr[i];
        } else{
            str += str + arr[i] + ",";
        }
    }
    console.log(str);
});
