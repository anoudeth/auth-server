#keytool
##### first we must generate a keystore file jwt.jks which contain the public and private key
> keytool -genkeypair -alias jwt -keyalg RSA -keypass password123 -keystore jwt.jks -storepass password123

##### it is recommended to migrate to PKCS12
> keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12

then copy file jwt.jks to resource dir

##### export public key
> keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey

then copy public key from -----BEGIN PUBLIC KEY----- to -----END PUBLIC KEY-----
and paste to resource server api

---------------

# spring-boot2-oauth2-auth-server-jwt-mysql

Hello Everyone,

Here is the video of Spring Boot 2.0 Authorization Server | OAuth2 | JWT and MySQL

https://youtu.be/wxebTn_a930

Please subscribe my YouTube channel - https://www.youtube.com/c/Talk2Amareswaran

Please like my Facebook page - https://www.facebook.com/talk2amareswaran/

Please join Facebook group - https://www.facebook.com/groups/271796230307847/