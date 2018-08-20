	DecorView extends FrameLayout(ViewGroup)
	public boolean superDispatchTouchEvent(MotionEvent event) {
		return super.dispatchTouchEvent(event);
	}