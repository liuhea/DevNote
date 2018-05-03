	public boolean dispatchTouchEvent(MotionEvent event) {
        //其他操作...
		
		//没有设置OnTouchListener,可以不管...
       
		
        return onTouchEvent(event);
    }
	public boolean onTouchEvent(MotionEvent event) {
		//其他操作,不管 如果可以点击则为true
		
		return false;
	}
	
	requestDisallowedInterceptTouchEvent(true);
	