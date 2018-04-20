package org.miniSpring.aop.Advisor;

/**
 * 描述切面的数据结构
 * @author hongyang.jiang
 */
public class Advisor {

	//干什么
	private Advice advice;
	//在哪里
	private PointCut pointCut;
	
	public Advice getAdvice() {
		return advice;
	}
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	public PointCut getPointCut() {
		return pointCut;
	}
	public void setPointCut(PointCut pointCut) {
		this.pointCut = pointCut;
	}
	
}
