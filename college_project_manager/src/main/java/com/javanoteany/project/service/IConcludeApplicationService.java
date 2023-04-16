package com.javanoteany.project.service;

import com.javanoteany.common.base.service.IBaseService;
import com.javanoteany.project.entity.ConcludeApplication;
 /**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface IConcludeApplicationService extends IBaseService<ConcludeApplication>{
    /**
     * 结题申请
     * @param concludeApplication
     * @return
     */
    ConcludeApplication toApplication(ConcludeApplication concludeApplication);

    /**
     * 结题通过
     * @param concludeApplication
     * @return
     */
    ConcludeApplication applicationPass(ConcludeApplication concludeApplication);

    /**
     * 结题未通过
     * @param concludeApplication
     * @return
     */
    ConcludeApplication applicationNotPass(ConcludeApplication concludeApplication);
}
