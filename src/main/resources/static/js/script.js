
fetch('../invoice')
    .then(res => res.json())
    .then(res => {
        var invoiceListNode = document.getElementById('invoice-list');
        invoiceListNode.innerHTML = "";

        var table = document.createElement("table");
        table.setAttribute("border","1");
        invoiceListNode.appendChild(table);

        res.forEach(invoice => {

            var tr = document.createElement("tr");
            table.appendChild(tr);

            var td = document.createElement("td");
            var text = document.createTextNode(`${invoice.number}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            text = document.createTextNode(`${invoice.customerName}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            var button = document.createElement("button");
            button.setAttribute("type","button");
            button.onclick = function() {
                showDetail(`${invoice.number}`);
            };
            text = document.createTextNode("Details");
            button.appendChild(text);
            td.appendChild(button);
            tr.appendChild(td);

        });

    });


function showDetail(invoiceNumber){
    fetch(invoiceNumber)
    .then(res => res.json())
    .then(res => {
        var invoiceDetailNode = document.getElementById('invoice-detail');
        invoiceDetailNode.innerHTML = "";

        var p = document.createElement("p");
        var text = document.createTextNode(`Number: ${res.number}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Customer name: ${res.customerName}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Order number: ${res.orderNumber}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

    });
}
//{"threads":[{"position":0,"start":0,"end":1066,"connection":"open"},{"position":2132,"start":1067,"end":2132,"connection":"closed"}],"url":"https://att-b.udemycdn.com/2020-06-03_01-17-54-05b1057fabaea4abd334191ab2db7e7b/original.js?secure=wIgM7IYN5TstNpp9CTi3IA%3D%3D%2C1597369208&filename=script.js","method":"GET","port":443,"downloadSize":2132,"headers":{"date":"Thu, 13 Aug 2020 21:14:49 GMT","content-type":"application/x-javascript","content-length":"2132","connection":"close","x-amz-id-2":"TtxnQ4e6WJTJ06nqaRV+e0L6M5/51TJ4ApQfudjASI85EcD1RNrgwIfliaDZAR7lzXFnw0qBNuQ=","x-amz-request-id":"17D41DB8C98D34DE","last-modified":"Wed, 03 Jun 2020 01:17:55 GMT","etag":"\"ddf4e45f07cbe8ea821a70b5aee4b6d6\"","x-amz-meta-qqfilename":"script.js","x-amz-version-id":"rvxLeUsIaMNk_mpXo607UtjummM3sVTg","x-77-nzt":"Ark73AGNsFf/Yn4KALmYQVMur5D9yncAAA==","x-edge-ip":"185.152.65.83","x-edge-pop":"pragueCZ","x-cache":"HIT","x-age":"30666","server":"CDN77-Turbo","cache-control":"max-age=31536000","content-disposition":"attachment; filename=\"script.js\"","x-lb-ip":"185.59.220.1","x-lb-pop":"frankfurtDE","x-cache-lb":"HIT","x-age-lb":"687714","accept-ranges":"bytes"}}