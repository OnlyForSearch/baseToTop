package cn.feng.utils.sms.entity;

/**
 * 短信接口返回信息实体
 * Created by fengYu Administrator on 2015/10/30.
 */
public class ReturnSms {

	   /**成功短信数：当成功后返回提交成功短信数*/
    private String successCounts;
    /**返回信息*/
    private String   message;
    /**返回余额*/
    private String remainpoint;
    /**返回本次任务的序列ID*/
    private String taskID;
	/**返回状态值：成功返回Success 失败返回：Faild*/
    private String returnstatus;
    
    /**成功短信数：当成功后返回提交成功短信数*/
    public String getSuccessCounts() {
        return successCounts;
    }
    /**成功短信数：当成功后返回提交成功短信数*/
    public void setSuccessCounts(String successCounts) {
        this.successCounts = successCounts;
    }
    /**返回信息*/
    public String getMessage() {
        return message;
    }
    /**返回信息*/
    public void setMessage(String message) {
        this.message = message;
    }
    /**返回余额*/
    public String getRemainpoint() {
        return remainpoint;
    }
    /**返回余额*/
    public void setRemainpoint(String remainpoint) {
        this.remainpoint = remainpoint;
    }
    /**返回本次任务的序列ID*/
    public String getTaskID() {
        return taskID;
    }
    /**返回本次任务的序列ID*/
    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    /**返回状态值：成功返回Success 失败返回：Faild*/
    public String getReturnstatus() {
		return returnstatus;
	}
    /**返回状态值：成功返回Success 失败返回：Faild*/
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	@Override
	public String toString() {
		return "ReturnSms [successCounts=" + successCounts + ", message=" + message + ", remainpoint=" + remainpoint + ", taskID=" + taskID + ", returnstatus="
				+ returnstatus + "]";
	}
}

