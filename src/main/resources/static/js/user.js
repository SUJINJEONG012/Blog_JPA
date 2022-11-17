let index= {	
	init:function(){
		$("#btn-save").on("click", ()=>{
		this.save();	
		});
	},
	
     save: function() {
        alert("user의 svae할수있음 ");
    }
    
}

index.init();