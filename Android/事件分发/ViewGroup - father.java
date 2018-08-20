/*************************************************************************/
/**
     * ViewGroup
     * @param ev
     * @return
     */
    public boolean dispatchTouchEvent(MotionEvent ev){
        ....//其他处理，在此不管
        View[] views=getChildView();
        for(int i=0;i<views.length;i++){
           //判断下Touch到屏幕上的点在该子View上面 
            if(...){
            if(views[i].dispatchTouchEvent(ev))
              return true;
             }
        }
        ...//其他处理，在此不管
    }
/*************************************************************************/
	
	View mTarget=null;//保存捕获Touch事件处理的View
    public boolean dispatchTouchEvent(MotionEvent ev) {

        //....其他处理，在此不管
        
        if(ev.getAction()==KeyEvent.ACTION_DOWN){
            //每次Down事件，都置为Null

            if (disallowIntercept || !onInterceptTouchEvent(ev)) {
            mTarget=null;
            View[] views=getChildView();
            for(int i=0;i<views.length;i++){
                if(views[i].dispatchTouchEvent(ev)){
                    mTarget=views[i];
                    return true;
				}
            }
          }
        }
        //当子View没有捕获down事件时，ViewGroup自身处理。这里处理的Touch事件包含Down、Up和Move
        if(mTarget==null){
            return super.dispatchTouchEvent(ev);
        }
        if (!disallowIntercept && onInterceptTouchEvent(ev)) {
            //其他操作,不管
			
            // clear the target
            mTarget = null;
            // Don't dispatch this event to our own view, because we already
            // saw it when intercepting; we just want to give the following
            // event to the normal onTouchEvent().
            return true;
        }
		//这一步在Action_Down中是不会执行到的，只有Move和UP才会执行到。
        return mTarget.dispatchTouchEvent(ev);

    }
	
	public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        if (disallowIntercept == ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0)) {
            // We're already in this state, assume our ancestors are too
            return;
        }

        if (disallowIntercept) {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } else {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        }

        // Pass it up to our parent
        if (mParent != null) {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }