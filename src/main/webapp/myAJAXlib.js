function createREQ() {
    try {
        return new XMLHttpRequest(); /* Works in modern browsers */
    } catch (err) {
        console.error("XMLHttpRequest creation failed", err);
        return false;
    }
}

function requestGET(url, query, req) {
    req.open("GET", url + '?' + query, true);
    req.send(null);
}

function requestPOST(url, query, req) {
    req.open("POST", url, true);
    req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    req.send(query);
}

function doCallback(callback, item) {
    if (typeof callback === 'function') {
        callback(item);
    } else {
        console.error("Callback is not a function");
    }
}

function doAjax(url, query, callback, reqtype, getxml = 0) {
    var myreq = createREQ();

    if (!myreq) {
        console.error("Request object creation failed");
        return;
    }

    myreq.onreadystatechange = function () {
        if (myreq.readyState === 4) {
            if (myreq.status === 200) {
                var item = getxml ? myreq.responseXML : myreq.responseText;
                doCallback(callback, item);
            } else {
                console.error("Request failed with status: " + myreq.status);
            }
        }
    };

    if (reqtype === 'post') {
        requestPOST(url, query, myreq);
    } else {
        requestGET(url, query, myreq);
    }
}