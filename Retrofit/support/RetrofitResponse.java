/*
 * *
 *  * Created by Paramjit.Rana on 03/09/21, 2:54 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 29/06/21, 12:27 PM
 *
 */

package support;

import okhttp3.ResponseBody;
import retrofit2.Response;

public interface RetrofitResponse
{
    void onServiceResponse(int requestCode, Response<ResponseBody> response);
}