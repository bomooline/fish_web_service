//package com.spring_boot_final.metasumer.service;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.GeneralSecurityException;
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.core.JsonFactory;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.googleapis.json.GoogleJsonResponseException;
//import com.google.api.client.http.HttpRequestInitializer;
//import com.google.api.client.http.javanet.NetHttpTransport; 
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.youtube.YouTube;  
//import com.google.api.services.youtube.model.SearchListResponse;
//
//@SuppressWarnings("deprecation")
//@Service
//public class YoutubeSearchService {
//	private static final String CLIENT_SECRETS= "client_secret.json";
//    private static final Collection<String> SCOPES =
//        Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");
//
//    private static final String APPLICATION_NAME = "API code samples";
//    private static final com.google.api.client.json.JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//
//    /**
//     * Create an authorized Credential object.
//     *
//     * @return an authorized Credential object.
//     * @throws IOException
//     */
//    public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
//        // Load client secrets.
//        InputStream in = ApiExample.class.getResourceAsStream(CLIENT_SECRETS);
//        GoogleClientSecrets clientSecrets =
//          GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow =
//            new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
//            .build();
//        Credential credential =
//            new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//        return credential;
//    }
//
//    /**
//     * Build and return an authorized API client service.
//     *
//     * @return an authorized API client service
//     * @throws GeneralSecurityException, IOException
//     */
//    public static YouTube getService() throws GeneralSecurityException, IOException {
//        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        Credential credential = authorize(httpTransport);
//        return new YouTube.Builder(httpTransport, JSON_FACTORY, (HttpRequestInitializer) credential)
//            .setApplicationName(APPLICATION_NAME)
//            .build();
//    }
//
//    /**
//     * Call function to create API service object. Define and
//     * execute API request. Print API response.
//     *
//     * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
//     */
//    public static void main(String[] args)
//        throws GeneralSecurityException, IOException, GoogleJsonResponseException {
//        YouTube youtubeService = getService();
//        // Define and execute the API request
//        YouTube.Search.List request = youtubeService.search().list("snippet");
//        SearchListResponse response = request.setMaxResults(25L)
//            .setOrder("viewCount")
//            .setPublishedAfter("2024-02-01T00:00:00Z")
//            .setQ("낚시")
//            .setSafeSearch("moderate")
//            .execute();
//        System.out.println(response);
//    }
//}
