/*
 * @Author: lee
 * @Date:2019/9/1 21:45
 * @Last Modified by:lee
 * @Last Modified time:2019/9/1 21:45
 */
const readline = require('readline');
const r1 = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});
var k = 2;
var inputs = [];
r1.on('line',function(input){
    inputs.push(input);
    if(k === inputs.length){
        var pre = inputs[0].split(',');
        var vin = inputs[1].split(',');
        console.log("前序遍历:" + pre);
        console.log("中序遍历:" + vin);
        var tree = reConstructBinaryTree(pre,vin);
        PrintFromTopToBottom(tree);
    }

});

// 构建树节点
function TreeNode(node){
    this.val = node;
    this.left = null;
    this.right = null;
}

// 重建二叉树
function reConstructBinaryTree(pre,vin){
    if(pre.length === 0 || vin.length === 0){
        return null;
    }
    var binaryTree = new TreeNode(pre[0]);
    var pre_left = [],
        pre_right = [],
        vin_left = [],
        vin_right = [];
    var index = vin.indexOf(pre[0]);
    pre_left = pre.slice(1,index+1);
    pre_right = pre.slice(index+1);
    vin_left = vin.slice(0,index);
    vin_right = vin.slice(index+1);
    binaryTree.left = reConstructBinaryTree(pre_left,vin_left);
    binaryTree.right = reConstructBinaryTree(pre_right,vin_right);
    return binaryTree;
}

// 打印二叉树
function PrintFromTopToBottom(root){
    // 用一个队列来存放二叉树
    var queue = [];
    queue.push(root);
    // result用来存放结果
    var result = [];
    if(root === null){
        return result;
    }
    // 只要队列里还有值，就一直打印
    while(queue.length){
        var temp = queue.shift();
        result.push(parseInt(temp.val));
        // 从左到右，按层级打印
        if(temp.left){
            queue.push(temp.left);
        }
        if(temp.right){
            queue.push(temp.right);
        }
    }
    console.log(result);
}