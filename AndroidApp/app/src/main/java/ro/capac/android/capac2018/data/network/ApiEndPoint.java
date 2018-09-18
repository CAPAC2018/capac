/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package ro.capac.android.capac2018.data.network;

import ro.capac.android.capac2018.BuildConfig;

/**
 * Created by amitshekhar on 01/02/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL
            + "/serverLogin";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/serverLogout";

    public static final String ENDPOINT_CREATE_EVENT = BuildConfig.BASE_URL
            + "/createEvent";

    public static final String ENDPOINT_CATEGORY_REQUEST = BuildConfig.BASE_URL
            +"/findEventsByCategory";

    public static final String ENDPOINT_REGISTRATION_REQUEST = BuildConfig.BASE_URL
            +"/registerUser";

    public static final String ENDPOINT_ATTEND_EVENT = BuildConfig.BASE_URL
            +"/attendEvent";

    public static final String ENDPOINT_MY_EVENTS_REQUEST = BuildConfig.BASE_URL
            +"/getMyEvents";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
