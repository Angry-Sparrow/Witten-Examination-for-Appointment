/*
 * @Author: lee
 * @Date:2019/7/24 16:23
 * @Last Modified by:lee
 * @Last Modified time:2019/7/24 16:23
 */
// 题目描述
// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。


const readline = require('readline');
const rl = readline.createInterface({
   input:process.stdin,
   output:process.stdout
});
rl.on('line',function(input){
    console.log(input.replace(/\s/g,'%20'));
});