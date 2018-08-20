	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (getWindow().superDispatchTouchEvent(ev)) {
			return true;
		}
		return onTouchEvent(ev);
	}
		
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}