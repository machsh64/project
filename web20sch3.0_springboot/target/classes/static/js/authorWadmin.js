function crash() {
    var title = document.getElementById("contact-title").value;
    var headLine = document.getElementById("contact-headLine").value;
    var content = document.getElementById("contact-content").value;
    var publish = document.getElementById("publish").value;

    if (isFull(title) && isFull(headLine && isFull(content)) && isFull(publish)) {
        alert("提交成功！");
        return true;
    }else {
        alert("提交失败！");
        return false;
    }
}

/* 判断字符是否不为空*/
function isFull(val) {
    var str = val.replace(/(^\s*)|(\s*$)/g, '');//去除空格;

    if (str == '' || str == undefined || str == null) {
        return false;
    } else {
        return true;
    }
}
