package org.com.facebook.facebook4j.networkanalysis;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Like;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;

public class FaceBookAPI {

	public static void main(String[] args) {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthAppId("").setOAuthAppSecret("")
				.setOAuthAccessToken("")
				.setOAuthPermissions("email,publish_stream,...");
		FacebookFactory ff = new FacebookFactory(cb.build());
		Facebook facebook = ff.getInstance();

		try {
			/*
			 * ResponseList<Post> feeds = facebook.getFeed("TEDxTucson", new
			 * Reading().limit(250));
			 * 
			 * for (int i = 0; i < feeds.size(); i++) { // Get post. Post post =
			 * feeds.get(i); // Get (string) message. String message =
			 * post.getMessage(); // Print out the message.
			 * System.out.println(message);
			 * 
			 * // Get more stuff... }
			 */

			/*
			 * Page page =facebook.getPage("TEDxTucson");
			 * System.out.println("Page Likes :" + page.getLikes());
			 */
			Reading reading = new Reading();
			reading.limit(2000);
			ResponseList<Like> likes = facebook.getUserLikes("TEDxTucson",
					reading);
			if (null != likes) {
				for (int i = 0; i < likes.size(); i++) {
					Like like = likes.get(i);
					System.out.println("pages" + i + ":" + like.getName());

				}
			} else {
				System.out.println("No likes!");
			}

		} catch (FacebookException e) {
			System.out.println("Error dude!  " + e.getErrorMessage());
		}

	}

}
