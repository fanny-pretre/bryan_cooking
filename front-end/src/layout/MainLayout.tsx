import { Box, Paper } from "@mui/material";
import { Outlet } from "react-router-dom";

import banner from "../assets/banner.png";
import Navbar from "../component/NavBar";

export default function MainLayout() {
  return (
    <Box sx={{ minHeight: "100dvh", bgcolor: "background.default" }}>
      <Box
        sx={{
          position: "relative",
          zIndex: 10,
        }}
      >
        <Navbar />
      </Box>
      <Box
        sx={{
          display: "block",

          position: "absolute",
          top: 0,
          left: 0,
          width: "100%",
          height: 180,

          backgroundImage: `url(${banner})`,
          backgroundSize: "cover",
          backgroundPosition: "center",

          zIndex: 0,
        }}
      />

      <Box
        sx={{
          mt: 10,
          px: {
            xs: 0,
            sm: 3,
          },
          pb: {
            xs: 10,
            md: 0,
          },
          position: "relative",
          zIndex: 1,
        }}
      >
        <Paper
          sx={{
            minHeight: {
              xs: "60dvh",
              sm: 400,
            },

            display: "flex",
            alignItems: "center",
            justifyContent: "center",

            bgcolor: "rgba(255,255,255,0.95)",

            backdropFilter: "blur(8px)",

            borderRadius: {
              xs: 2,
              sm: 2,
            },

            boxShadow: "0 10px 30px rgba(0,0,0,0.15)",

            px: {
              xs: 2,
              sm: 4,
            },

            py: {
              xs: 4,
              sm: 6,
            },
          }}
        >
          <Outlet />
        </Paper>
      </Box>
    </Box>
  );
}
