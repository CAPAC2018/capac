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

import android.util.Log;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import ro.capac.android.capac2018.data.network.model.AuthenticationRequest;
import ro.capac.android.capac2018.data.network.model.AuthenticationResponse;
import ro.capac.android.capac2018.data.network.model.EventRequest;
import ro.capac.android.capac2018.data.network.model.EventResponse;

/**
 * Created by janisharali on 28/01/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<AuthenticationResponse.LoginResponse> doGoogleLoginApiCall(AuthenticationRequest.LoginRequest.GoogleLoginRequest
                                                              request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(AuthenticationResponse.LoginResponse.class);
    }

    @Override
    public Single<AuthenticationResponse.LoginResponse> doFacebookLoginApiCall(AuthenticationRequest.LoginRequest.FacebookLoginRequest
                                                                request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(AuthenticationResponse.LoginResponse.class);
    }

    @Override
    public Single<AuthenticationResponse.LoginResponse> doServerLoginApiCall(AuthenticationRequest.LoginRequest.ServerLoginRequest
                                                              request) {
        Log.d(getClass().getSimpleName(), "doServerLoginApiCall: " + request);
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(AuthenticationResponse.LoginResponse.class);
    }

    @Override
    public Single<EventResponse.CreateEventResponse> doCreateEventApiCall(EventRequest.CreateEventRequest request){
        Log.d(getClass().getSimpleName(), "doCreateEventApiCall: " + request);
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_CREATE_EVENT)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(EventResponse.CreateEventResponse.class);
    }

    @Override
    public Single<EventResponse.EventsList> doRequestEventsByCategory(EventRequest.GetEventsByCategoryRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_CATEGORY_REQUEST)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(EventResponse.EventsList.class);
    }

    @Override
    public Single<AuthenticationResponse.LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(AuthenticationResponse.LogoutResponse.class);
    }

    @Override
    public Single<AuthenticationResponse.RegistrationResponse> doServerUserRegistration(AuthenticationRequest.RegistrationRequest.ServerRegistrationRequest request){
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_REGISTRATION_REQUEST)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(AuthenticationResponse.RegistrationResponse.class);
    }

    @Override
    public Single<EventResponse.AttendEventResponse> doAttendEventRequest(EventRequest.AttendEventRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_ATTEND_EVENT)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(EventResponse.AttendEventResponse.class);
    }

    @Override
    public Single<EventResponse.EventsList> doGetMyEvents(EventRequest.MyEventsRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_MY_EVENTS_REQUEST)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(EventResponse.EventsList.class);
    }
}

