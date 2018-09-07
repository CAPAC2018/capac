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

import io.reactivex.Single;
import ro.capac.android.capac2018.data.network.model.EventRequest;
import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.data.network.model.LoginRequest;
import ro.capac.android.capac2018.data.network.model.LoginResponse;
import ro.capac.android.capac2018.data.network.model.LogoutResponse;
import ro.capac.android.capac2018.data.network.model.RegistrationRequest;
import ro.capac.android.capac2018.data.network.model.RegistrationResponse;

/**
 * Created by janisharali on 27/01/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<EventResponse.CreateEventResponse> doCreateEventApiCall(EventRequest.CreateEventRequest request);

    Single<EventResponse.CategorizedEvents> doRequestEventsByCategory(EventRequest.GetEventsByCategoryRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<RegistrationResponse> doServerUserRegistration(RegistrationRequest.ServerRegistrationRequest request);
}
