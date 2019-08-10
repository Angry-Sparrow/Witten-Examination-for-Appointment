/*
 * @Author: lee
 * @Date:2019/8/2 11:41
 * @Last Modified by:lee
 * @Last Modified time:2019/8/2 11:41
 */

function a() {
    setTimeout( function(){
        console.log(1)
    }, 1000);
    setTimeout( function(){
        console.log(2)
    }, 0);
    console.log(3);
}
a();