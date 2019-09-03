/*
 * @Author: lee
 * @Date:2019/9/1 21:28
 * @Last Modified by:lee
 * @Last Modified time:2019/9/1 21:28
 */

// 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
// （从0开始，第0项为0）。
// n<=39

const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});
rl.on('line',function(input){
    var n = parseInt(input);
    Fibonacci(n);
});
function Fibonacci(n){
    if(n === 0){
        return 0;
    }else if(n === 1){
        return 1;
    }
    var Fibona = [0,1];
    for(var  i = 2; i <= n; i++){
        Fibona.push(Fibona[i - 1] + Fibona[i - 2]);
    }
    console.log(Fibona.pop());
}