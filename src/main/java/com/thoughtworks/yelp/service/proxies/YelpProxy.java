package com.thoughtworks.yelp.service.proxies;

import android.content.Context;
import com.thoughtworks.bitemoi.R;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class YelpProxy {
    private final OAuthService oAuthService;
    private final Token token;

    public YelpProxy(
            String consumerKey,
            String consumerSecret,
            String token,
            String tokenSecret) {
        this.oAuthService = new ServiceBuilder()
                .provider(YelpApiService.class)
                .apiKey(consumerKey)
                .apiSecret(consumerSecret)
                .build();
        this.token = new Token(token, tokenSecret);
    }
    public static YelpProxy getYelp(Context context) {
        return new YelpProxy(context.getString(R.string.consumer_key), context.getString(R.string.consumer_secret),
                context.getString(R.string.token_key), context.getString(R.string.token_secret));
    }

    public String search(String term, double latitude, double longitude) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("ll", latitude + "," + longitude);
        this.oAuthService.signRequest(this.token, request);
        Response response = request.send();
        return response.getBody();
    }
}
