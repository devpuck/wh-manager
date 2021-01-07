package com.wms.util.check;

import com.wms.errorcode.ErrorCode;

/**
 * @author puck
 * @date 2020/12/16 9:59 下午
 */
public class CheckParameter
{
    public static int checkParameter(String parmeter)
    {
        if(null == parmeter|| "".equals(parmeter))
        {
            return ErrorCode.ERROR;
        }
        return ErrorCode.OK;
    }

    public static int checkParameter(String parmeter,String parmeter2)
    {
        if(ErrorCode.ERROR == checkParameter(parmeter) ||(ErrorCode.ERROR == checkParameter(parmeter2)))
        {
            return ErrorCode.ERROR;
        }

        return ErrorCode.OK;
    }

    public static int checkParameter(String parmeter,String parmeter2,String parmeter3)
    {
        if(ErrorCode.ERROR == checkParameter(parmeter) ||(ErrorCode.ERROR == checkParameter(parmeter2)) ||(ErrorCode.ERROR == checkParameter(parmeter3)))
        {
            return ErrorCode.ERROR;
        }

        return ErrorCode.OK;
    }

    public static int checkParameter(String parmeter,String parmeter2,String parmeter3,String parmeter4)
    {
        if(ErrorCode.ERROR == checkParameter(parmeter,parmeter2) ||(ErrorCode.ERROR == checkParameter(parmeter3,parmeter4)))
        {
            return ErrorCode.ERROR;
        }

        return ErrorCode.OK;
    }

    public static int checkParameter(String parmeter,String parmeter2,String parmeter3,String parmeter4,String parmeter5)
    {
        if(ErrorCode.ERROR == checkParameter(parmeter,parmeter2) ||(ErrorCode.ERROR == checkParameter(parmeter3,parmeter4,parmeter5)))
        {
            return ErrorCode.ERROR;
        }

        return ErrorCode.OK;
    }

    public static int checkParameter(String parmeter,String parmeter2,String parmeter3,String parmeter4,String parmeter5,String parmeter6)
    {
        if(ErrorCode.ERROR == checkParameter(parmeter,parmeter2,parmeter6) ||(ErrorCode.ERROR == checkParameter(parmeter3,parmeter4,parmeter5)))
        {
            return ErrorCode.ERROR;
        }

        return ErrorCode.OK;
    }

    public static int checkParameter(String parmeter,String parmeter2,String parmeter3,String parmeter4,String parmeter5,String parmeter6,String parmeter7)
    {
        if(ErrorCode.ERROR == checkParameter(parmeter,parmeter2,parmeter6) ||(ErrorCode.ERROR == checkParameter(parmeter3,parmeter4,parmeter5,parmeter7)))
        {
            return ErrorCode.ERROR;
        }

        return ErrorCode.OK;
    }
}
