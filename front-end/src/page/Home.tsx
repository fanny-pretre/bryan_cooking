import { Box, Button, Stack, Typography } from "@mui/material";
import bowl from "../assets/bowl.png";
import { Link } from "react-router-dom";

export default function Home() {
  return (
    <Box
      sx={{
        minHeight: "100dvh",
        bgcolor: "background.default",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        px: 2,
      }}
    >
      <Stack
        spacing={2}
        sx={{
          alignItems: "center",
          textAlign: "center",
        }}
      >
        <Typography
          component="h1"
          variant="h4"
          sx={{
            fontWeight: 600,
          }}
        >
          Where is{" "}
          <Typography
            component="span"
            variant="h4"
            sx={{
              color: "primary.main",
              fontWeight: 600,
            }}
          >
            Bryan
          </Typography>
          ?
        </Typography>

        <Typography
          component="p"
          variant="h6"
          sx={{
            fontWeight: 600,
          }}
        >
          Bryan is in the{" "}
          <Typography
            component="span"
            variant="h6"
            sx={{
              color: "primary.main",
              fontWeight: 600,
            }}
          >
            kitchen
          </Typography>
        </Typography>

        <Box
          component="img"
          src={bowl}
          alt=""
          sx={{
            width: {
              xs: 250,
              sm: 280,
            },
            opacity: 0.8,
          }}
        />
        <Typography
          variant="body1"
          color="text.secondary"
          sx={{
            maxWidth: {
              xs: 250,
              sm: 450,
            },
          }}
        >
          Planifiez vos menus et gérez vos courses en toute simplicité.
        </Typography>

        <Stack
          sx={{
            width: "100%",
            maxWidth: 420,
            flexDirection: {
              xs: "column",
              sm: "row",
            },
            gap: 2,
          }}
        >
          <Button variant="contained" fullWidth component={Link} to="/login">
            Connectez-vous
          </Button>

          <Button variant="outlined" fullWidth component={Link} to="/register">
            Inscrivez-vous
          </Button>
        </Stack>
      </Stack>
    </Box>
  );
}
