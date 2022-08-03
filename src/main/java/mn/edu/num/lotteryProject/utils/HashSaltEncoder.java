package mn.edu.num.lotteryProject.utils;

public class HashSaltEncoder {
    //    public void hashWithSalt(String username, String password){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = bCryptPasswordEncoder.encode(password);
//    }
////
////    @Override
////    public void hashPassword(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
////        SecureRandom secureRandom = new SecureRandom();
////        //make sure to save this into a database
////        byte[] salt = secureRandom.generateSeed(12);
////
////        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, 10, 512);
////        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
////        byte[] hash = skf.generateSecret(pbeKeySpec).getEncoded();
////
////        //converting to string to store into database
////        String base64Hash = Base64.getMimeEncoder().encodeToString(hash);
////
////        User user = new User();
////        user.setHash(base64Hash);
////        user.setSalt(new String(salt));
////
////    }
}
