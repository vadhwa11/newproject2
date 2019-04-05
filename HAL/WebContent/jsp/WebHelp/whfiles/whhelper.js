/*************************************************************************

Fly Help Web Help Helper Library 1.0
Copyright (c) 2001-2005 Fly Sky Software,Inc. 
http://www.flyskysoft.com

Tested with: Internet Explorer 5-6, Opera 6-7, Mozilla 1.2, Firefox 1.1

ATTENTION! You can use this library only with web help system 
generated by Fly Help software.  
               
**************************************************************************/

function FindTop(start) {
    if (start == top) return top;
    try { t = start.parent.name; } catch (e) { return start; }
    return FindTop(start.parent);
}
var webhelptop = FindTop(self);

function FindFrame(frameName, start) {
    if (start == null) return null;

    var resframe = null;
    var frames = start.frames;
    if (frames.length == 0) return null;

    for (var i = 0; i < frames.length; i++) {
        tmpFrame = frames[i];

        try { tmpFrameName = tmpFrame.name; }
        catch (e) { continue; }

        if (tmpFrameName.toUpperCase() == frameName.toUpperCase()) {
            resframe = frames[i];
        } else {
            resframe = FindFrame(frameName, tmpFrame);
        }
        if (resframe != null) return resframe;
    } return null;
}

function navDelta(incr) {
    next = pagenum;
    if (incr < 0) {
        for (i = pagenum - 1; i >= 0; i--)
            if (ContentFiles[i] != null) {
            next = i;
            break;
        }
    } else {
        for (i = pagenum + 1; i < ContentFiles.length; i++)
            if (ContentFiles[i] != null) {
            next = i;
            break;
        }
    }
    if (next == pagenum) return;
    var url = ContentFiles[next];
    try {
        contree.dOpenTreeNode(next);
    } catch (e) {
        pagenum = next;
    };

    webhelptop.whtopframe.pageid = url;
    window.open(url, "content");
}

function conPrint() {
    var frame = FindFrame("content", top);
    if (frame && frame.focus && frame.print && !window.opera) {
        frame.focus();
        frame.print();
    } else {
        alert("Sorry, your browser does not support the print feature.");
    }
}

function getElement(doc, sID) {
    if (doc.getElementById)
        return doc.getElementById(sID);
    else if (doc.all)
        return doc.all(sID);
    return null;
}

var gbShow = true;
var gstrFrameLastSetting = "";
var gbtntab1 = null;
var gbtntab2 = null;
var gbtntxt = null;
var gcurpage = 0;

function OnClickButton(btnId) {
    var doc = webhelptop.whtopframe.document;
    if (btnId == 0 && doc.gcurpage != 0) {
        window.open('whnavc.html', 'toc');
        document.location = 'whheaderc.html';
    }
    else if (btnId == 1 && doc.gcurpage != 1) {
        window.open('whnavi.html', 'toc');
        document.location = 'whheaderi.html';
    }
    else if (btnId == 2 && doc.gcurpage != 2) {
        window.open('whnavs.html', 'toc');
        document.location = 'whheaders.html';
    }
    else {
        if (doc.gbShow == false) {
            showPane();

            var btntabid1;
            var btntabid2;
            var btntxtid;

            if (doc.gcurpage == 0) {
                btntabid1 = "tabcontents1";
                btntabid2 = "tabcontents2";
                btntxtid = "btncontents";
            }
            else if (doc.gcurpage == 1) {
                btntabid1 = "tabindex1";
                btntabid2 = "tabindex2";
                btntxtid = "btnindex";
            }
            else if (doc.gcurpage == 2) {
                btntabid1 = "tabsearch1";
                btntabid2 = "tabsearch2";
                btntxtid = "btnsearch";
            }

            var btntab1 = document.getElementById(btntabid1);
            btntab1.style.backgroundColor = selbtnbordercolor;
            doc.gbtntab1 = btntab1;

            var btntab2 = document.getElementById(btntabid2);
            btntab2.style.backgroundColor = selbtnbgcolor;
            doc.gbtntab2 = btntab2;

            var btntxt = document.getElementById(btntxtid);
            btntxt.style.color = selbtntxtcolor;
            doc.gbtntxt = btntxt;
        }
    }
}

function hidePane() {
    var doc = webhelptop.whtopframe.document;

    var oFrameset = getElement(doc, "whPfset");

    if (doc.gbShow == true) {
        if (oFrameset) {
            doc.gstrFrameLastSetting = oFrameset.cols;
            var oWnd = frames[0];
            if (oWnd && oWnd.document && oWnd.document.body) {
                var nPos = 0;
                if ("cols" == "cols")
                    nPos = oWnd.document.body.offsetWidth;
                else
                    nPos = oWnd.document.body.offsetHeight;
                if (0 == 0)
                    doc.gstrFrameLastSetting = nPos + ",*";
                else
                    doc.gstrFrameLastSetting = "*," + nPos;
            }
            oFrameset.cols = "0,*";
        }
        doc.gbShow = false;

        if (doc.gbtntab1)
            doc.gbtntab1.style.backgroundColor = btnbordercolor;
        if (doc.gbtntab2)
            doc.gbtntab2.style.backgroundColor = btnbgcolor;
        if (doc.gbtntxt)
            doc.gbtntxt.style.color = btntxtcolor;
    }
}

function showPane() {
    var doc = webhelptop.whtopframe.document;

    var oFrameset = getElement(doc, "whPfset");

    if (oFrameset) {
        if (doc.gstrFrameLastSetting)
            oFrameset.cols = doc.gstrFrameLastSetting;
        else
            oFrameset.cols = "250,*";
    }
    doc.gbShow = true;
}

function syncTopic() {
    open('whheaderc.html', 'header');
    open('whnavc.html', 'toc');
}