dojo.provide("my.FixedHeaderTable");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("dojo.string");
dojo.declare("my.FixedHeaderTable",
	[dijit._Widget,dijit._Templated],
	{
		headers : [],
		rows: [],
		tableHeight: '200px',
		tableWidth:'100%',
		noDataMsg: null,
		columnWidth: [],
		sortable:true,
		sorted_column: [],
		templatePath: dojo.moduleUrl("dojo122","../../dojo/my/widget/templates/FixedHeaderTable.html"),

		postCreate:function(){
			this.id = this.domNode.id;
			var _this = this;
			var len = this.headers.length - 1;
			dojo.forEach(this.headers,function(i,index){
				var div = document.createElement('div');
				if ( _this.sortable && _this.sorted_column[index] ){
					div.className = "sortable";
					div.onclick=function(e){
						dojo.publish('sort/fixedHeaderTable_'+_this.id,
							[{index:index,type:_this.sorted_column[index]}]);
					};
				}
				var s = document.createElement('span');
				s.innerHTML = i;
				div.appendChild(s);
				if ( index == len ) { div.style.borderRight = 'none'; }
				_this.fixedHeader.appendChild(div);
			});
			if ( this.noDataMsg || ! this.rows[0] ) {
				this.createEmptyTableBody();
			} else {
				this.addTableBody(this.rows);
			}
			
			this.Wrapper.id='fixedHeaderTable_'+this.id;
			dojo.query('.fixedHeaderTable',this.id)
				.style({width:this.tableWidth});
			this.Wrapper.parentNode.style.minWidth=this.tableWidth;
			dojo.query('.fixedHeaderTableBodyWrapper',this.id) 
				.style({height:this.tableHeight});
			dojo.query('tr td:last-child').style({borderRight:'none'});
			this.Container.id='fixedHeaderTableBody_'+this.id;
			this.adjustWidth();
			dojo.connect(window,'onresize',this.adjustWidthOnResize);
			if ( this.sortable ) {
				dojo.subscribe('sort/fixedHeaderTable_'+this.id,this,"sortByThisColumn");
			}
			
		},
		sortByThisColumn: function(i) {
			var _this = this;
			var ascend = 1;
			var col = i.index;
			var sortType = i.type;
			function cmp(a,b) {
				if ( sortType == 'numeric' ) {
					return (ascend) ? a-0 > b-0 : a-0 < b-0;
				}
				else {
					return (ascend) 
						? (a.toLowerCase() > b.toLowerCase()) 
						: (a.toLowerCase() < b.toLowerCase());
				}
			}
			function swap(t,a,b){
				if ( dojo.isIE ) {
					var d = t.rows[a];
					var tmp = d.parentElement.removeChild(d);
					var s = t.rows[i];
					s.parentElement.insertBefore(tmp,s);
				}
				else {
					var tmp = t.removeChild(t.rows[a]);
					if ( b % 2 ) { t.rows[b].className = 'row_a'; }
					else { t.rows[b].className = 'row_b'; }
      				t.insertBefore(tmp, t.rows[b]);
				}
			}
			var A = []; var B = [];
			var t = dojo.isIE 
				? document.getElementById('fixedHeaderTableBody_'+_this.id)
				: dojo.query('tbody','fixedHeaderTableBody_'+_this.id)[0];
				
			for (var i = 0; i < t.rows.length; i++) {
				A[i] = dojo.isIE ? t.rows[i].cells[col].innerText : t.rows[i].cells[col].textContent;
				B[i] = i;
			}
			for ( var i = 1; i<A.length; i++ ){
				var value = A[i];
				var v = B[i];
				var j = i-1;
				while( j>=0 && cmp(A[j],value)){
					A[j + 1] = A[j];
					B[j+1] = B[j];
            		j = j-1;
				}
				B[j+1] = v;
				A[j+1] = value;
			}
			for (var j=0;j<B.length-1;j++) {
				var s = B[j];
				if ( s == j ) continue;
				swap(t,B[j],j);
				for (var n=j+1;n<B.length;n++){
					if ( B[n] < s ) B[n]++;
				}
			}
			this.fixeClassName();
			//dojo.query('tr:nth-child(even)',t).removeClass('row_a').addClass('row_b');
			//dojo.query('tr:nth-child(odd)',t).removeClass('row_b').addClass('row_a');
		},
		fixeClassName: function(){
			var tt = dojo.query('tbody','fixedHeaderTableBody_'+this.id)[0];
			var cl = 'row_b';
			for (var i = 0; i < tt.rows.length; i++) {
				cl = (cl == 'row_b') ? 'row_a' : 'row_b';
				var c = tt.rows[i];
				c.className = cl;
			}
		},
		updateTableBody: function(rows){
			dojo.query('>',this.Container).orphan();
			if ( rows && rows[0] ) { 
				this.addTableBody(rows);
				this.adjustWidth(); 
			}
			else { this.createEmptyTableBody(); }
		},
		addTableBody: function(rows){
			var _this = this;
			var tb = document.createElement('tbody');
			dojo.forEach(rows,function(row,index){
				var tr = document.createElement('tr');
				if ( index % 2 ) { tr.className = row.className ? 'row_b '+row.className : 'row_b';	}
				else { tr.className = row.className ? 'row_a '+row.className : 'row_a';	}
				dojo.forEach(row.data,function(cell,i){
					var td = document.createElement('td');
					if ( _this.columnWidth && _this.columnWidth[i] ) {
						td.style.width = _this.columnWidth[i];
					}
					td.innerHTML = cell;
					tr.appendChild(td);
					
				});
				tb.appendChild(tr);
			});
			_this.Container.appendChild(tb);
		},
		createEmptyTableBody: function(){
			var _this = this;
			var tb = document.createElement('tbody');
			var tr = document.createElement('tr');
			tr.style.visibility = 'hidden';
		
			dojo.forEach(this.headers,function(i,index){
				var td = document.createElement('td');
				td.style.borderColor = 'transparent';
				if ( _this.columnWidth && _this.columnWidth[i] ) {
					td.style.width = _this.columnWidth[i];
				}
				td.innerHTML = i;
				tr.appendChild(td);
			});
			tb.appendChild(tr);
			tr = document.createElement('tr');
			var td = document.createElement('td');
			//td.setAttribute("colspan",this.headers.length);
			td.colSpan=this.headers.length;
			td.style.textAlign = "center";
			td.style.borderColor = 'transparent';
			var span = document.createElement('span');
			span.className = "noDataMsg";
			span.innerHTML = this.noDataMsg || 'No records';
			td.appendChild(span);
			tr.appendChild(td);
			tb.appendChild(tr);
			_this.Container.appendChild(tb);
		},
		adjustWidth: function(){
			var _this = this;
			var divs = dojo.query('div',this.fixedHeader);
			var tds = dojo.query('tr:first-child td',this.Container);
		
			var padding_left_plus_right = 10;
    		for ( var i=0;i<divs.length-1;i++ ){
        		if ( divs[i].clientWidth != tds[i].clientWidth ) {
            		var w = tds[i].clientWidth - padding_left_plus_right;
            		divs[i].style.width = w+'px';
        		}
    		}
		},
		adjustWidthOnResize:function(){
			var tables = dojo.query('.fixedHeaderTable');
			dojo.forEach(tables,function(tab){
				var id = tab.id;
				var divs = dojo.query('.fixedHeaderTableHeader div',tab.id);
				var tds = dojo.query('tr:first-child td',tab.id);
				var padding_left_plus_right = 10;
    			for ( var i=0;i<divs.length-1;i++ ){
        			if ( divs[i].clientWidth != tds[i].clientWidth ) {
            			var w = tds[i].clientWidth - padding_left_plus_right;
            			divs[i].style.width = w+'px';
        			}
    			}
			});
		},
		addClassNameColumn: function(o){
			var q = o.row 
				? dojo.string.substitute('tr:nth-child(${row}) td:nth-child(${col})',{row:o.row,col:o.column})
				: dojo.string.substitute('td:nth-child(${col})',{col:o.column});
			dojo.query(q,this.Container).addClass(o.className);
		},
		addClassNameRow: function(o){
			var q = o.row 
				? dojo.string.substitute('tr:nth-child(${nth})',{nth:o.row})
				: 'tr';
			dojo.query(q,this.Container).addClass(o.className);
		},
		removeClassNameColumn: function(o){
			var q = o.row 
				? dojo.string.substitute('tr:nth-child(${row}) td:nth-child(${col})',{row:o.row,col:o.column})
				: dojo.string.substitute('td:nth-child(${col})',{col:o.column});
			dojo.query(q,this.Container).removeClass(o.className);
		},
		removeClassNameRow: function(o){
			var q = o.row 
				? dojo.string.substitute('tr:nth-child(${nth})',{nth:o.row})
				: 'tr';
			dojo.query(q,this.Container).removeClass(o.className);
		}
	}
);