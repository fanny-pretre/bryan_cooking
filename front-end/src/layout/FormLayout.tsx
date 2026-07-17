import { Box, Container, Paper } from "@mui/material";
import { Outlet } from "react-router-dom";

import banner from "../assets/banner.png";

export default function MainLayout() {
  return (
    <Box
      sx={{
        position: "relative",
        minHeight: "100dvh",
        bgcolor: "background.default",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        px: 2,
        overflow: "hidden",
      }}
    >
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

      <Container
        maxWidth="sm"
        disableGutters
        sx={{
          position: "relative",
          zIndex: 1,
        }}
      >
        <Paper
          elevation={0}
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
      </Container>
    </Box>
  );
}
