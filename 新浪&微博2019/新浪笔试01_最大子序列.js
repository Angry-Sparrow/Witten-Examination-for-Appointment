/*
 * @Author: lee
 * @Date:2019/8/31 17:14
 * @Last Modified by:lee
 * @Last Modified time:2019/8/31 17:14
 */
// 输入形式：13,-45,-53,-14,-75,-87,-99,57,55,81,-1
// 输出形式：193|57,55,81
// 输出为最大子序列的和值|最大子序列


const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
rl.on('line', function (input) {
    var inputArr = input.split(",");
    getMaxSumSeqArr(inputArr);
});
//通过每次与前一位的最大连续子串的信息做比较进行拼接
function getTempByPrevSeq(PrevTemp, currentValue) {
    //这里规定，0也可以进行子串拼接
    if (PrevTemp.sum >= 0) {
        return {
            num: PrevTemp.num + 1,
            sum: PrevTemp.sum + currentValue
        };
    } else {
        return {
            num: 1,
            sum: currentValue
        }
    }
}
function getMaxSumSeqArr(input) {
    if (input.length === 0) return;
    var temps = []; // 存储每一位与前面连续之后可得最大值的信息，以便后面的每一位进行迭代更新
    //第一位向前的最大子串就是它自己本身
    var temp = {
        num: 1,
        sum: input[0]
    };
    temps.push(temp);
    for (var i = 1, len = input.length; i < len; i++) {
        var ref = input[i];
        //从前向后迭代
        var temp = getTempByPrevSeq(temps[i-1], ref);
        temps.push(temp);
    }
    //存储了迭代过程中的信息, 可以在这里看看
    var maxValue, //获取最大值
        indexArr = []; //获取多个结果的index
    maxValue = temps[0].sum;
    indexArr.push(0);
    for (var i = 1, len = temps.length; i < len; i++) {
        var ref = temps[i];
        if (ref.sum === maxValue) {
            indexArr.push(i);
        } else if (ref.sum > maxValue) {
            maxValue = ref.sum;
            indexArr.length = 0; //重置数组
            indexArr.push(i);
        }
    }
    var str="";
    for (var i = 0, len = indexArr.length; i < len; i++) {
        var index     = indexArr[i],
            ref     = temps[index];
        var arr = input.slice(index-ref.num+1, index+1);
        console.log(arr);
    }
    if(arr[arr.length-1] <= 0){
        arr.splice(-1);
    }
    var maxNum =0;
    for(var i = 0;i<arr.length;i++){
        console.log("arr["+i+"]="+arr[i]);
        maxNum=parseInt(maxNum)+parseInt(arr[i]);
    }
    str=maxNum+"|";
    for(var i=0;i<arr.length;i++){
        if(i===arr.length-1){
            str+=arr[i];
        }else{
            str+=arr[i]+",";
        }
    }
    console.log(str);
}